package com.example.cards.service.impl;

import com.example.cards.constants.CardsConstants;
import com.example.cards.dto.CardsDto;
import com.example.cards.entity.Cards;
import com.example.cards.exception.CardAlreadyExistsException;
import com.example.cards.exception.ResourceNotFoundException;
import com.example.cards.mapper.CardsMapper;
import com.example.cards.repository.CardsRepository;
import com.example.cards.service.ICardsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardsServiceImpl implements ICardsService {

    private CardsRepository cardsRepository;

    /**
     * @param mobileNumber - mobile number of the customer
     */
    @Override
    public void createCard(String mobileNumber) {
        Optional<Cards> optionalCards= cardsRepository.findByMobileNumber(mobileNumber);
        if(optionalCards.isPresent()){
            throw new CardAlreadyExistsException("Card already exists for this mobile number");
        }
        cardsRepository.save(createNewCard(mobileNumber));
    }

    /**
     * This method creates a new card with a random card number and sets the initial limit.
     *
     * @param mobileNumber - input mobile number
     * @return Cards object with the generated card details
     */

    private Cards createNewCard(String mobileNumber) {
        Cards newCard = new Cards();
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setMobileNumber(mobileNumber);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setCardType(CardsConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);

        newCard.setCreatedAt(LocalDateTime.now());
        newCard.setCreatedBy("MS_TEAM");
        return newCard;
    }

    /**
     * @param mobileNumber - input mobile number
     * @return Card details based on a given mobileNumber
     */
    @Override
    public CardsDto fetchCard(String mobileNumber) {
        Cards cards=cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card","mobileNumber", mobileNumber)
        );
        return CardsMapper.toDto(cards, new CardsDto());
    }

    /**
     * @param cardsDto - CardsDto object , FIND CARDS BY CARD NUMBER , AND UPDATE THE CARDS DETAILS.
     * @return boolean indicating if the update of the card details is successful or not.
     */
    @Override
    public boolean updateCard(CardsDto cardsDto) {
        Cards cards=cardsRepository.findByCardNumber(cardsDto.getCardNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Card","cardNumber", cardsDto.getCardNumber())
        );
        CardsMapper.toEntity(cardsDto, cards);
        cardsRepository.save(cards);
        return true;
    }

    /**
     * @param mobileNumber - input mobile number
     * @return boolean indication if the delete of cards details is succesful or not
     */
    @Override
    public boolean deleteCard(String mobileNumber) {
        Cards cards=cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card","mobileNumber", mobileNumber)
        );
        cardsRepository.delete(cards);
        return true;
    }
}
