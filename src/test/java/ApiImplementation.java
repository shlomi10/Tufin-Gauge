import com.thoughtworks.gauge.Step;

import java.io.IOException;

import static api.MainApiFunction.getRootJSON;

public class ApiImplementation {

    String baseUrl = "https://reqres.in/api/users/";

    @Step("validate Tobias Funke in list")
    public void validateTobiasFunkeInList() throws IOException {
        int counter = 0;
        for (int i = 1; i <= 12; i++) {
            String firstName = getRootJSON(baseUrl + i).getData().getFirstName();
            String lastName = getRootJSON(baseUrl + i).getData().getLastName();
            if (firstName.equals("Tobias") && lastName.equals("Funke")) {
                counter++;
            }
        }
        System.out.println("Tobias was on the list " + counter + " time");
    }
}
