package SERVICE;

import DAO.OperationIMPL;
import DTO.CurrentAccount;
import DTO.Operation;
import INTERFACES.OperationDAO;

import java.sql.SQLException;
import java.util.Optional;

public class OperationService {
    public Optional<Operation> insertOperation(Operation operation) {
        Optional<Operation> Operationipml = Optional.empty();
        try {
            OperationDAO Operationdao = new OperationIMPL();
            Operationipml = Operationdao.insert(operation);
            Operationipml = Optional.of(Operationipml.get());
        } catch (Exception e) {
            System.out.println(e + " :Not Found");
        }
        return Operationipml;
    }
    public Optional<Operation> getOneOperation(int operationNum) {
        Optional<Operation> Operationipml = Optional.empty();
        try {
            OperationDAO Operationdao = new OperationIMPL();
            Operationipml = Operationdao.getOne(operationNum);
            Operationipml = Optional.of(Operationipml.get());
        } catch (Exception e) {
            System.out.println(e + " :Not Found");
        }
        return Operationipml;
    }

    public Boolean deleteOperation(int num) {
        boolean Operationipml = false;
        try {
            OperationDAO Operationdao = new OperationIMPL();
            Operationipml = Operationdao.delete(num);
        } catch (Exception e) {
            System.out.println(e + " :Not Found");
        }
        return Operationipml;
    }
}
