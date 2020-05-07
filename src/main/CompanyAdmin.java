package main;

public class CompanyAdmin {
    private Company company;

    public CompanyAdmin() {
    }

    public CompanyAdmin(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
