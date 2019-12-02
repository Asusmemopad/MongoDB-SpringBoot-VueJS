package rc.springbootmongodb.service;

import org.springframework.stereotype.Service;
import rc.springbootmongodb.model.Hotel;

import java.util.List;
import java.util.Optional;


public interface HotelService {
    List<Hotel> getAllHotel();
    Hotel getHotel(String hotelId);
    Hotel saveHotel(Hotel hotel);
    Hotel updateHotel(Hotel hotel);
    void deleteHotel(String hotelId);
}
