package domain.entity;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
@Getter
@Setter
public class UserEntity {
    private String vName;
    private String lName;
    private String vEmail;
    private MasterDataEntity address;
    private ArrayList<BankAccountEntity> accounts;
}
