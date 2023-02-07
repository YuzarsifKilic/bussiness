package com.yuzarsif.business.dto.request;

public class CreateCompanyRequest {

    private String email;
    private String password;
    private String companyName;
    private String webSite;

    public CreateCompanyRequest() {}

    public CreateCompanyRequest(String email, String password, String companyName, String webSite) {
        this.email = email;
        this.password = password;
        this.companyName = companyName;
        this.webSite = webSite;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getWebSite() {
        return webSite;
    }
}
