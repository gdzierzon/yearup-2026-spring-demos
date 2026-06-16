let productService;

class ProductService {
    products = [];
    editingId = null;

    loadProducts() {
        axios.get(`${config.baseUrl}/products`)
            .then(response => {
                this.products = response.data.map(p => ({
                    ...p,
                    categoryName: p.category.categoryName
                }));


                console.log(this.products);
                
                templateBuilder.build('products', { products: this.products }, 'main');
            })
            .catch(() => showError('Could not load products.'));
    }

    showProductForm(product = {}) {
        const isEdit = !!product.productId;
        this.editingId = isEdit ? product.productId : null;
        const selectedCategoryId = product.category ? product.category.categoryId : null;

        categoryService.getAll()
            .then(categories => {
                const data = {
                    formTitle: isEdit ? 'Edit Product' : 'Add Product',
                    productId: product.productId || '',
                    productName: product.productName || '',
                    unitPrice: product.unitPrice || 0,
                    categories: categories.map(category => ({
                        ...category,
                        selected: category.categoryId === selectedCategoryId ? 'selected' : ''
                    }))
                };

                templateBuilder.build('product-form', data, 'product-form', () => {
                    document.getElementById('product-form').classList.remove('hidden');
                });
            })
            .catch(() => showError('Could not load categories for the product form.'));
    }

    editProduct(id) {
        axios.get(`${config.baseUrl}/products/${id}`)
            .then(response => this.showProductForm(response.data))
            .catch(() => showError(`Could not load product ${id}.`));
    }

    saveProduct() {
        const productId = document.getElementById('productId').value || null;
        const categoryId = parseInt(document.getElementById('categoryId').value);

        const product = {
            productId,
            productName: document.getElementById('productName').value.trim(),
            unitPrice: parseFloat(document.getElementById('unitPrice').value),
            category: {
                categoryId
            }
        };

        if (!product.productName || Number.isNaN(product.unitPrice) || !categoryId) {
            showError('Product name, unit price, and category are required.');
            return;
        }

        const request = this.editingId
            ? axios.put(`${config.baseUrl}/products/${this.editingId}`, product)
            : axios.post(`${config.baseUrl}/products`, product);

        request.then(() => {
                showMessage(this.editingId ? 'Product updated.' : 'Product added.');
                this.editingId = null;
                this.loadProducts();
            })
            .catch(() => showError('Could not save product.'));
    }

    deleteProduct(id) {
        axios.delete(`${config.baseUrl}/products/${id}`)
            .then(() => {
                showMessage('Product deleted.');
                this.loadProducts();
            })
            .catch(() => showError(`Could not delete product ${id}.`));
    }
}

document.addEventListener('DOMContentLoaded', () => {
    productService = new ProductService();
});
