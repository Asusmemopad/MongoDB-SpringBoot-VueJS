package rc.springbootmongodb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rc.springbootmongodb.model.Hotel;
import rc.springbootmongodb.repository.HotelRepository;
import rc.springbootmongodb.service.HotelService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Hotel>> getAll(){
        List<Hotel> hotelList = hotelService.getAllHotel();

        if (hotelList == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(hotelList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable("id") String id){
        Hotel hotel = hotelService.getHotel(id);

        if (hotel == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(hotel,HttpStatus.OK);
    }
}
