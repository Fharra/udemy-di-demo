package guru.springframework;

import guru.springframework.controllers.ConstructorInjectedController;
import guru.springframework.controllers.MyController;
import guru.springframework.controllers.PropertyInjectedController;
import guru.springframework.controllers.SetterInjectedController;
import guru.springframework.examplebeans.FakeDataSource;
import guru.springframework.examplebeans.OtherFakeDataSource;
import javax.print.attribute.standard.MediaSize.Other;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);
		MyController controller = (MyController) ctx.getBean("myController");
		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		System.out.println(fakeDataSource.getUser());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getUrl());
		OtherFakeDataSource otherFakeDataSource = ctx.getBean(OtherFakeDataSource.class);
		System.out.println(otherFakeDataSource.getPasswordOther());
		System.out.println(otherFakeDataSource.getUserOther());
	}
}
