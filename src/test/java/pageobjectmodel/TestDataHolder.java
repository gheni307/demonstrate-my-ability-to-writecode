package pageobjectmodel;

public class TestDataHolder {

    private String title;
    private String email;
    private  String productName;
    private String productCode;

    public TestDataHolder() {
    }

    public TestDataHolder(String title, String email, String productName, String productCode) {
        this.title = title;
        this.email = email;
        this.productName = productName;
        this.productCode = productCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
