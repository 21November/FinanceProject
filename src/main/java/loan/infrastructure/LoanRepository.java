package loan.infrastructure;

import halpers.IRepository;
import loan.domain.Loan;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class LoanRepository implements IRepository<Loan> {
    @Override
    public void insert(Loan loan) {

    }

    @Override
    public void update(Loan loan) {

    }

    @Override
    public void delete(String name) {

    }

    @Override
    public List<Loan> getAll() {
        return null;
    }

    @Override
    public Optional<Loan> getById(long id) {
        return Optional.empty();
    }

    //Методы для работы с таблицей Кредиты
}
