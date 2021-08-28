package by.mikhed.ITS.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FindTransactionRequest {

    private Integer transferNumber;
}
