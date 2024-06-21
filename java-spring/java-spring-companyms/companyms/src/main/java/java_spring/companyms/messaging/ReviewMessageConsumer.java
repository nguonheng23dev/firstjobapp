package java_spring.companyms.messaging;

import java_spring.companyms.company.CompanyService;
import java_spring.companyms.dto.ReviewMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class ReviewMessageConsumer {
    private final CompanyService companyService;
    public ReviewMessageConsumer(CompanyService companyService) {
        this.companyService = companyService;
    }
    @RabbitListener(queues = "companyRatingQueue")
    public void consumeMessage(ReviewMessage reviewMessage){
        companyService.updateCompanyRating(reviewMessage);
    }
}
