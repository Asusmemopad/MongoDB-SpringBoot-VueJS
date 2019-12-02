package rc.springbootmongodb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rc.springbootmongodb.model.Hotel;
import rc.springbootmongodb.repository.HotelRepository;
import rc.springbootmongodb.service.HotelService;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String hotelId) {
        return null;
    }

    @Override
    public Hotel saveHotel(Hotel hotel) {
        return null;
    }

    @Override
    public Hotel updateHotel(Hotel hotel) {
        return null;
    }

    @Override
    public void deleteHotel(String hotelId) {

    }
}
