package adapter.dto;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
@Getter
@Setter

public class BuchDto {
    private String vName;
    private String lName;
    private String vEmail;
    private MasterDataDto address;
    private ArrayList<BankAccountDto> accounts;
}
