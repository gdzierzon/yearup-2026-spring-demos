let customerService;

class CustomerService {
    customers = [];
    editingId = null;

    getAuthConfig()
    {
        const token = localStorage.getItem("token");

        return {
            headers: {
                Authorization: `Bearer ${token}`
            }
        };
    }


    loadCustomers(queryString) {

        const url = (queryString)
            ?`${config.baseUrl}/customers?${queryString}`
            : `${config.baseUrl}/customers`

        axios.get(url)
            .then(response => {
                this.customers = response.data.map(c => ({
                    customerId: c.customerId ?? "",
                    companyName: c.companyName ?? "",
                    contactName: c.contactName ?? "",
                    city: c.city ?? "",
                    state: c.state ?? '',
                    zip: c.zip ?? "",
                    country: c.country ?? "",
                }));
                templateBuilder.build('customers', { customers: this.customers }, 'main');
            })
            .catch(() => showError('Could not load customers. Make sure the Northwind API is running.'));
    }

    showCustomerForm(customer = {}) {
        const isEdit = !!customer.customerId;
        this.editingId = isEdit ? customer.customerId : null;

        const data = {
            formTitle: isEdit ? 'Edit Customer' : 'Add Customer',
            customerId: customer.customerId || '',
            companyName: customer.companyName || '',
            contactName: customer.contactName || '',
            address: customer.address || '',
            city: customer.city || '',
            state: customer.state || '',
            zip: customer.zip || '',
            country: customer.country || '',
            idReadOnly: isEdit ? 'readonly' : ''
        };

        templateBuilder.build('customer-form', data, 'customer-form', () => {
            document.getElementById('customer-form').classList.remove('hidden');
        });
    }

    editCustomer(id) {
        axios.get(`${config.baseUrl}/customers/${id}`)
            .then(response => this.showCustomerForm(response.data))
            .catch(() => showError(`Could not load customer ${id}.`));
    }

    saveCustomer() {
        const customer = {
            customerId: document.getElementById('customerId').value.trim().toUpperCase(),
            companyName: document.getElementById('companyName').value.trim(),
            contactName: document.getElementById('contactName').value.trim(),
            address: document.getElementById('address').value.trim(),
            city: document.getElementById('city').value.trim(),
            state: document.getElementById('state').value.trim(),
            zip: document.getElementById('zip').value.trim(),
            country: document.getElementById('country').value.trim()
        };

        if (!customer.customerId || !customer.companyName) {
            showError('Customer ID and company name are required.');
            return;
        }

        const request = this.editingId
            ? axios.put(`${config.baseUrl}/customers/${this.editingId}`, customer, authenticationService.getAuthConfig())
            : axios.post(`${config.baseUrl}/customers`, customer, authenticationService.getAuthConfig());

        request.then(() => {
                showMessage(this.editingId ? 'Customer updated.' : 'Customer added.');
                this.editingId = null;
                this.loadCustomers();
            })
            .catch(() => showError('Could not save customer.'));
    }

    deleteCustomer(id) {
        axios.delete(`${config.baseUrl}/customers/${id}`, authenticationService.getAuthConfig())
            .then(() => {
                showMessage('Customer deleted.');
                this.loadCustomers();
            })
            .catch(() => showError(`Could not delete customer ${id}.`));
    }
}

document.addEventListener('DOMContentLoaded', () => {
    customerService = new CustomerService();
});
