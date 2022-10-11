import "./ReviewCard.style.css";

export const ReviewCard = ({ review }) => {
  return (
    <div className="review-card-wrapper">
      <img src={review.imagemUrl} alt="" />
      <div>
        <p>{review.comentario}</p>
        <span>Nota: {review.nota}</span>
      </div>
    </div>
  );
};
