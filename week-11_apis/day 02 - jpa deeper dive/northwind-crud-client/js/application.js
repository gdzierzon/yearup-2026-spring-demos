function showMessage(message) {
    templateBuilder.append('message', { message }, 'messages');
}

function showError(error) {
    templateBuilder.append('error', { error }, 'errors');
}

function hideForm(formId) {
    const form = document.getElementById(formId);
    if (form) {
        form.classList.add('hidden');
        form.innerHTML = '';
    }
}

function showCustomers() {
    customerService.loadCustomers();
}

function showCategories() {
    categoryService.loadCategories();
}

function showProducts() {
    productService.loadProducts();
}

function newCustomer() {
    customerService.showCustomerForm();
}

function editCustomer(id) {
    customerService.editCustomer(id);
}

function saveCustomer() {
    customerService.saveCustomer();
}

function deleteCustomer(id) {
    if (confirm(`Delete customer ${id}?`)) {
        customerService.deleteCustomer(id);
    }
}

function newCategory() {
    categoryService.showCategoryForm();
}

function editCategory(id) {
    categoryService.editCategory(id);
}

function saveCategory() {
    categoryService.saveCategory();
}

function deleteCategory(id) {
    if (confirm(`Delete category ${id}?`)) {
        categoryService.deleteCategory(id);
    }
}

function newProduct() {
    productService.showProductForm();
}

function editProduct(id) {
    productService.editProduct(id);
}

function saveProduct() {
    productService.saveProduct();
}

function deleteProduct(id) {
    if (confirm(`Delete product ${id}?`)) {
        productService.deleteProduct(id);
    }
}

document.addEventListener('DOMContentLoaded', () => {
    templateBuilder.build('header', {}, 'header');
    showCustomers();
});
