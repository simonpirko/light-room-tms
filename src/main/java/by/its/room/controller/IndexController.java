package by.its.room.controller;

import by.its.room.model.Room;
import by.its.room.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/")
public class IndexController {

    private final RoomService roomService;

    public IndexController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        List<Room> rooms = roomService.allListRooms();
        modelAndView.addObject("rooms", rooms);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView addRoom(ModelAndView modelAndView) {
        modelAndView.setViewName("redirect:/");
        roomService.addRoom(new Room());
        return modelAndView;
    }
}
