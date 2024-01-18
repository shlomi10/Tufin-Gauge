import com.thoughtworks.gauge.Step;

import java.io.IOException;

import static api.MainApiFunction.getRootJSON;

public class ApiImplementation {

    String baseUrl = "https://reqres.in/api/users/";

    @Step("validate <firstName> <lastName> in list")
    public void validateTobiasFunkeInList(String firstName, String lastName) throws IOException {
        int counter = 0;
        for (int i = 1; i <= 12; i++) {
            String actualFirstName = getRootJSON(baseUrl + i).getData().getFirstName();
            String actualLastName = getRootJSON(baseUrl + i).getData().getLastName();
            if (actualFirstName.equals(firstName) && actualLastName.equals(lastName)) {
                counter++;
            }
        }
        System.out.println("Tobias was on the list " + counter + " time");
    }
}
