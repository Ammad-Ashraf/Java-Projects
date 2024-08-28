package Service1.UserService.Entities;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Account Information
    private String userType;
    private String firstName;
    private String lastName;
    private String preferredProducts;
    private String email;
    private String password;

    // Company Information
    private String company;
    private String mobileNumber;
    private String fiscalAddress;
    private String zipCode;
    private String country;
    private String companyActivity;

    // Constructors
    public users() {
    }

    public users(String userType, String firstName, String lastName, String preferredProducts,
                String email, String password, String company, String mobileNumber,
                String fiscalAddress, String zipCode, String country, String companyActivity) {
        this.userType = userType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.preferredProducts = preferredProducts;
        this.email = email;
        this.password = password;
        this.company = company;
        this.mobileNumber = mobileNumber;
        this.fiscalAddress = fiscalAddress;
        this.zipCode = zipCode;
        this.country = country;
        this.companyActivity = companyActivity;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id2) {
        this.id = id2;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPreferredProducts() {
        return preferredProducts;
    }

    public void setPreferredProducts(String preferredProducts) {
        this.preferredProducts = preferredProducts;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getFiscalAddress() {
        return fiscalAddress;
    }

    public void setFiscalAddress(String fiscalAddress) {
        this.fiscalAddress = fiscalAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCompanyActivity() {
        return companyActivity;
    }

    public void setCompanyActivity(String companyActivity) {
        this.companyActivity = companyActivity;
    }

    // toString method
    @Override
    public String toString() {
        return "users{" +
                "id=" + id +
                ", userType='" + userType + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", preferredProducts=" + preferredProducts +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", company='" + company + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", fiscalAddress='" + fiscalAddress + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                ", companyActivity='" + companyActivity + '\'' +
                '}';
    }
}
