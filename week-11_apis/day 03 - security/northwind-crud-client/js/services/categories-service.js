let categoryService;

class CategoryService {
    categories = [];
    editingId = null;

    getAll() {
        return axios.get(`${config.baseUrl}/categories`)
            .then(response => response.data);
    }

    loadCategories() {
        this.getAll()
            .then(categories => {
                this.categories = categories;
                templateBuilder.build('categories', { categories }, 'main');
            })
            .catch(() => showError('Could not load categories.'));
    }

    showCategoryForm(category = {}) {
        const isEdit = !!category.categoryId;
        this.editingId = isEdit ? category.categoryId : null;

        const data = {
            formTitle: isEdit ? 'Edit Category' : 'Add Category',
            categoryId: category.categoryId || '',
            categoryName: category.categoryName || '',
            description: category.description || ''
        };

        templateBuilder.build('category-form', data, 'category-form', () => {
            document.getElementById('category-form').classList.remove('hidden');
        });
    }

    editCategory(id) {

        const token = localStorage.getItem("token");
        axios.get(`${config.baseUrl}/categories/${id}`)
            .then(response => this.showCategoryForm(response.data))
            .catch(() => showError(`Could not load category ${id}.`));
    }

    saveCategory() {
        const category = {
            categoryId: document.getElementById('categoryId').value || null,
            categoryName: document.getElementById('categoryName').value.trim(),
            description: document.getElementById('description').value.trim()
        };

        if (!category.categoryName) {
            showError('Category name is required.');
            return;
        }


        const request = this.editingId
            ? axios.put(`${config.baseUrl}/categories/${this.editingId}`, category, authenticationService.getAuthConfig())
            : axios.post(`${config.baseUrl}/categories`, category, authenticationService.getAuthConfig());

        request.then(() => {
                showMessage(this.editingId ? 'Category updated.' : 'Category added.');
                this.editingId = null;
                this.loadCategories();
            })
            .catch(() => showError('Could not save category.'));
    }

    deleteCategory(id) {
        axios.delete(`${config.baseUrl}/categories/${id}`, authenticationService.getAuthConfig())
            .then(() => {
                showMessage('Category deleted.');
                this.loadCategories();
            })
            .catch(() => showError(`Could not delete category ${id}. It may still have products assigned to it.`));
    }
}

document.addEventListener('DOMContentLoaded', () => {
    categoryService = new CategoryService();
});
