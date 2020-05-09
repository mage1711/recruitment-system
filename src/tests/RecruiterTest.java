package tests;

import enums.AccountState;
import enums.AccountType;
import main.Company;
import main.Database;
import main.Recruiter;
import main.UserFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecruiterTest {
    Recruiter createFakeRecruiter() {
        UserFactory userFactory = new UserFactory(AccountType.Recruiter);
        Company company = Company.getCompany(1);
        // commitToDatabase is called inside the constructor
        return (Recruiter) userFactory.createUser("Test Recruiter", "recruiter@test.test", "123123",
                                                  AccountType.Recruiter, AccountState.Pending, company);
    }

    // Creates account
    @Test
    void commitToDatabaseCreate() {
        Database.init();
        var newRecruiter = createFakeRecruiter();
        var retrievedRecruiter = Recruiter.getRecruiter(newRecruiter.getEmail());
        assertEquals(retrievedRecruiter.getId(), newRecruiter.getId());
        newRecruiter.deleteAccount();
    }

    // Updates account
    @Test
    void commitToDatabaseUpdate() {
        Database.init();
        var newRecruiter = createFakeRecruiter();
        newRecruiter.setName("hahahahaha");
        newRecruiter.commitToDatabase();
        var retrievedRecruiter = Recruiter.getRecruiter(newRecruiter.getId());
        assertEquals(newRecruiter.getName(), retrievedRecruiter.getName());
        newRecruiter.deleteAccount();
    }
}