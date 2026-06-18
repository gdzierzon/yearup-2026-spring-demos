function showMessage(message) {
    templateBuilder.append('message', { message }, 'messages');

    // timeout find the messages div and clear it
    setTimeout(function() {
        const div = document.getElementById("messages");
        div.innerText =''
    }, 2000);
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

function searchCustomers() {
    const company = document.getElementById("searchCompany").value
    const contact = document.getElementById("searchContact").value
    const city = document.getElementById("searchCity").value
    const country = document.getElementById("searchCountry").value

    let url = ""
    if(company) url += `&company=${company}`
    if(contact) url += `&contact=${contact}`
    if(city) url += `&city=${city}`
    if(country) url += `&country=${country}`

    if(url.length === 0) url = null
    customerService.loadCustomers(url);
}

function showCategories() {
    categoryService.loadCategories();
}

function showProducts() {
    productService.loadProducts();
}

function searchProducts() {
    const categoryName = document.getElementById("searchCategoryName").value
    const productName = document.getElementById("searchProductName").value
    const minPrice = document.getElementById("searchMinPrice").value
    const maxPrice = document.getElementById("searchMaxPrice").value
    let url = ""
    if(categoryName) url += `&category=${categoryName}`
    if(productName) url += `&name=${productName}`
    if(minPrice) url += `&minprice=${minPrice}`
    if(maxPrice) url += `&maxprice=${maxPrice}`

    if(url.length === 0) url = null
    productService.loadProducts(url);
}

function showLogin() {
    authenticationService.showLoginForm();
}

function showLogout() {
    localStorage.removeItem("token")
    showMessage("You are now logged out")
    customerService.loadCustomers();
}

function login() {
    const userName = document.getElementById("userNameBox").value
    const password = document.getElementById("passwordBox").value

    authenticationService.login(userName, password);
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
