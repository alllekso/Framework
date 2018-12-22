package com.academy.automationpractice.ddt.tests;

import com.academy.automationpractice.ddt.framework.model.AddressData;
import com.academy.automationpractice.ddt.framework.model.Addresses;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressTests extends BaseTest {

    @BeforeMethod
    public void prepare() {
        manager.goTo().home();
        manager.session().login();
        manager.goTo().address();
    }

    @Test(dataProvider = "creationAddress")
    public void testAddAddress(AddressData address) {
        System.out.println("start 'testAddAddress'");

        if (manager.address().isPresentAlias(address.getAlias())) {
            manager.address().remove(address.getAlias());
        }

        Addresses before = manager.address().all();
        manager.address().create(address);

        // verify
        assertThat(manager.address().count(), equalTo(before.size()+1));
        Addresses after = manager.address().all();
        assertThat(after, equalTo(before.withAdded(address.withUpperCaseAlias())));

        System.out.println("complete 'testAddAddress'");
    }

    @Test(dataProvider = "creationAddress")
    public void testDellAddress(AddressData address) {

        if (manager.address().isPresentAlias(address.getAlias())) {
            manager.address().remove(address.getAlias());

        }
        manager.address().create(address);
        Addresses before = manager.address().all();
        manager.address().remove(address.getAlias());

        // verify
        assertThat(manager.address().count(), equalTo(before.size()-1));

        System.out.println("complete 'testAddAddress'");
    }

    @DataProvider(name="creationAddress")
    private Object[][] getCreationAddressData() {
        List<AddressData> addressData = ReaderExcel.readAddress();
        Object[][] testData = new Object[addressData.size()][1];

        for (int i =0; i < addressData.size(); i++){
            testData[i][0] = addressData.get(i);
        }
        return testData;
    }
    @AfterMethod
    public void logout(){
        manager.session().logout();
    }
}
