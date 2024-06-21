package firstjobapp_ms.java_spring.Service;

import firstjobapp_ms.java_spring.Entity.Company;
import firstjobapp_ms.java_spring.Entity.Review;
import firstjobapp_ms.java_spring.Repository.CompanyRepository;
import firstjobapp_ms.java_spring.Repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImplement implements ReviewService{
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;
    public ReviewServiceImplement(ReviewRepository reviewRepository,
                                  CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if(company != null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updateReview) {
        if(companyService.getCompanyById(companyId) != null){
            updateReview.setCompany(companyService.getCompanyById(companyId));
            updateReview.setId(reviewId);
            reviewRepository.save(updateReview);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if(companyService.getCompanyById(companyId) != null && reviewRepository.existsById(reviewId)){
            Review review = reviewRepository.findById(reviewId).orElse(null);
            Company company = review.getCompany();
            company.getReviews().remove(review);
            companyService.updateCompany(company,companyId);
            reviewRepository.deleteById(reviewId);
            return true;
        }else {
            return false;
        }
    }
}
