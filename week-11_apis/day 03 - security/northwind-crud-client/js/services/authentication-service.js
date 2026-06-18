let authenticationService;

class AuthenticationService {

    getAuthConfig()
    {
        const token = localStorage.getItem("token");

        return {
            headers: {
                Authorization: `Bearer ${token}`
            }
        };
    }

    showLoginForm() {

        templateBuilder.build('login', {}, 'main');
    }

    login(userName, password)
    {
        const login = {
            username: userName,
            password: password
        };


        const request =  axios.post(`${config.baseUrl}/login`, login);

        request.then((response) => {
                const token = response.data.token;

                localStorage.setItem("token", token)

                showMessage(`Welcome back ${userName}`);
                categoryService.loadCategories();
            })
            .catch(() => showError('Login failed.'));
    }

}

document.addEventListener('DOMContentLoaded', () => {
    authenticationService = new AuthenticationService();
});
