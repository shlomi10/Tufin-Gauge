import api.Data;
import com.thoughtworks.gauge.Step;

import static api.MainApiFunction.getRootJSON;

public class ApiImplementation {

    String baseUrl = "https://reqres.in/api/users/";

    @Step("validate <firstName> <lastName> in list")
    public void validateTobiasFunkeInList(String firstName, String lastName) {
        int counter = 0;
        for (int i = 1; i <= 12; i++) {
            try {
                Data data = getRootJSON(baseUrl + i).getData();
                String actualFirstName = data.getFirstName();
                String actualLastName = data.getLastName();
                if (actualFirstName.equals(firstName) && actualLastName.equals(lastName)) {
                    counter++;
                }
            } catch (Exception e) {
                System.out.println("There is no user in that page, the exception: " + e.getMessage());
            }
        }
        System.out.println("Tobias was on the list " + counter + " time");
    }
}
