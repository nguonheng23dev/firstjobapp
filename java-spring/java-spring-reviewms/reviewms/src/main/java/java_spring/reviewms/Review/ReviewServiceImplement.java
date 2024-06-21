package java_spring.reviewms.Review;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImplement implements ReviewService{
    private final ReviewRepository reviewRepository;
    public ReviewServiceImplement(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        if(companyId != null && review != null){
            review.setCompanyId(companyId);
            reviewRepository.save(review);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Review getReview(Long reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    @Override
    public boolean updateReview(Long reviewId, Review updateReview) {
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if(review != null){
            updateReview.setTitle(updateReview.getTitle());
            updateReview.setDescription(updateReview.getDescription());
            updateReview.setRating(updateReview.getRating());
            updateReview.setCompanyId(updateReview.getCompanyId());
            reviewRepository.save(updateReview);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteReview(Long reviewId) {
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if(review != null){
            reviewRepository.delete(review);
            reviewRepository.deleteById(reviewId);
            return true;
        }else {
            return false;
        }
    }
}
