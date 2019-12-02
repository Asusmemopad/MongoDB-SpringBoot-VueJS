package rc.springbootmongodb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import rc.springbootmongodb.model.Hotel;
import rc.springbootmongodb.repository.HotelRepository;
import rc.springbootmongodb.service.HotelService;

import java.util.List;

public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String hotelId) {
        return null;
    }

    @Override
    public Hotel save(Hotel hotel) {
        return null;
    }

    @Override
    public Hotel update(Hotel hotel) {
        return null;
    }

    @Override
    public void deleteHotel(String hotelId) {

    }
}
