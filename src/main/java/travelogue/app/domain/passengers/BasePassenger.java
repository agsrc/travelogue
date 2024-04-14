package travelogue.app.domain.passengers;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public abstract class BasePassenger {
    private String name;
    private int passengerNumber;

}
