package gov.nj.treas.NJDPB_ADMIN_Server;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NjdpbAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NjdpbAdminServerApplication.class, args);
	}

}
