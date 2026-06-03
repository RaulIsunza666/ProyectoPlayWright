package Utilidades;

public class CredencialesLogin {
    private String url;
    private String userName;
    private String password;

    private CredencialesLogin(Builder builder) {
        this.url = builder.url;
        this.userName = builder.userName;
        this.password = builder.password;
    }

    public String getPagina() {
        return url;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public static class Builder {
        private String url;
        private String userName;
        private String password;

        public Builder conUsuario(String usuario) {
            this.userName = usuario;
            return this;
        }

        public Builder conPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder conUrl(String url) {
            this.url = url;
            return this;
        }

        // Método que construye el objeto final
        public CredencialesLogin build() {
            return new CredencialesLogin(this);
        }
    }
}