package by.its.room.controller;

import by.its.room.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/room")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping(path = "/{id}")
    public ModelAndView findRoom(@PathVariable("id") Long id, ModelAndView modelAndView) {
        modelAndView.setViewName("currentRoom");
        modelAndView.addObject("room", roomService.findRoomById(id));
        return modelAndView;
    }

    @PostMapping
    public ModelAndView changeRoom(@RequestParam("light") Integer option,
                                   @RequestParam("id") Long id, ModelAndView modelAndView) {
        modelAndView.setViewName("redirect:/room/" + id);
        if (option == 1) {
            roomService.lightOn(id);
        } else if (option == 0) {
            roomService.lightOff(id);
        }
        return modelAndView;
    }


}
