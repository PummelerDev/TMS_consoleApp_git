import pack.user.Address;
import pack.user.Company;
import pack.user.Geo;
import pack.user.User;

import java.util.ArrayList;
import java.util.List;

public class ManualEditing {

    public static void start() {
        while (true) {
            System.out.println("""
                    Make a choose to add info into the table.
                    1 - create a new User
                    Enter "exit" to return.
                    """);
            String sc = MyUtils.getNumb(1);
            if (sc.equals("exit")) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            switch (sc) {
                case "1" -> {
                    User user1 = new User();
                    System.out.println("id");
                    user1.setId(String.valueOf(MyUtils.fromKeyboardInt()));
                    System.out.println("name");
                    user1.setName(MyUtils.fromKeyboardString());
                    System.out.println("username");
                    user1.setUsername(MyUtils.fromKeyboardString());
                    System.out.println("email");
                    user1.setEmail(MyUtils.fromKeyboardEmail());
                    {
                        Address address = new Address();
                        System.out.println("address/street");
                        address.setStreet(MyUtils.fromKeyboardString());
                        System.out.println("address/suite");
                        address.setSuite(MyUtils.fromKeyboardString());
                        System.out.println("address/zipcode");
                        address.setZipcode(String.valueOf(MyUtils.fromKeyboardInt()));
                        {
                            Geo geo = new Geo();
                            System.out.println("address/geo/lat");
                            geo.setLat(String.valueOf(MyUtils.fromKeyboardInt()));
                            System.out.println("address/geo/lng");
                            geo.setLng(String.valueOf(MyUtils.fromKeyboardInt()));
                            address.setGeo(geo);
                        }
                        user1.setAddress(address);
                    }
                    System.out.println("phone");
                    user1.setPhone(MyUtils.fromKeyboardPhone());
                    System.out.println("website");
                    user1.setWebsite(MyUtils.fromKeyboardWebsite());
                    {
                        Company company = new Company();
                        System.out.println("company/name");
                        company.setName(MyUtils.fromKeyboardString());
                        System.out.println("company/catchPhrase");
                        company.setCatchPhrase(MyUtils.fromKeyboardString());
                        System.out.println("company/bs");
                        company.setBs(MyUtils.fromKeyboardString());
                        user1.setCompany(company);
                    }
                    List<User> users = new ArrayList<>();
                    users.add(user1);
                    sb.append("INSERT INTO users(id, name, username, email, address, phone, website, company) VALUES");
                    for (User user : users) {
                        sb.append("(")
                                .append(user.getId()).append(", ")
                                .append("'").append(user.getName()).append("'").append(", ")
                                .append("'").append(user.getUsername()).append("'").append(", ")
                                .append("'").append(user.getEmail()).append("'").append(", ")
                                .append("'").append(user.getAddress().toString()).append("'").append(", ")
                                .append("'").append(user.getPhone()).append("'").append(", ")
                                .append("'").append(user.getWebsite()).append("'").append(", ")
                                .append("'").append(user.getCompany().toString()).append("'")
                                .append(")").append(",");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    MyConnection.connect(sb.toString());
                }
            }

        }
    }
}
