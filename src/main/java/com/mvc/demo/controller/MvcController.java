package com.mvc.demo.controller;

import com.mvc.demo.models.Order;
import com.mvc.demo.models.OrderItem;
import com.mvc.demo.models.Users;
import com.mvc.demo.services.OrderItemService;
import com.mvc.demo.services.OrderService;
import com.mvc.demo.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Random;


@Controller
public class MvcController {
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;


    @RequestMapping("/")
    public String DD(Model model) {
        List<Order> listorders = orderService.getOrders();
        model.addAttribute("listorders", listorders);
        return "orderList";
    }

    @RequestMapping("/new")
    public String showNewProductPage(Model model) {

        Order order = new Order();
        model.addAttribute("order", order);

        return "AddOrder";
    }

    @RequestMapping(value = "/saveOrderItem", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("orderItem") OrderItem order, Long id) {

        OrderItem orderItem = new OrderItem();


        Random rand = new Random();

        Long int_random = rand.nextLong();
        System.out.println("hahah");
        System.out.println(order.getOrders().getTitle());
        order.setId(int_random);

        orderItemService.save(order);
        return "redirect:/";

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("order") Order order) {
        List<Users> one = userService.getUsers();
        Users user = one.get(0);
        Random rand = new Random();
        Long int_random = rand.nextLong();
        order.setId(int_random);
        order.setUsers(user);
        orderService.save(order);
        return "redirect:/";

    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_order");
        Order order = orderService.getOneOrder(id);
        mav.addObject("order", order);

        return mav;
    }

    @RequestMapping("/create/createOrderItem/{id}")
    public ModelAndView createOrderItem(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("create_orItem");
        Order order = orderService.getOneOrder(id);
        OrderItem orderItem = new OrderItem();
        orderItem.setOrders(order);
        mav.addObject("orderItem", orderItem);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        orderService.deleteOrder(id);
        return "redirect:/";
    }

    @RequestMapping(value = {"/orders/{orderId}/edit"},  method = RequestMethod.POST)
    public String updateContact(Model model,
                                @PathVariable long orderId,
                                @ModelAttribute("order") Order order) {

        order.setId(orderId);
        orderService.edit(order);
        return "redirect:/";

    }

}
