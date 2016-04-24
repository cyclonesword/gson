/**
 * Created by Domenico on 17/04/2016.
 */
public class Address {

    private String address;
    private String city;
    private String postal_code;
    private String state;

    public Address(String address, String city, String postal_code, String state) {
        this.address = address;
        this.city = city;
        this.postal_code = postal_code;
        this.state = state;
    }

    public Address() {

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
