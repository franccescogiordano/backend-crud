package co.com.sofka.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {
    @Autowired
    private TodoService service;

    @GetMapping(value = "api/todos")
    public Iterable<Todo> list(){
        return service.list();
    }
    @PostMapping(value = "api/todo")
    public Todo save(@RequestBody Todo todo){
        return service.save(todo);
    }
    @PutMapping(value = "api/todo")
    public Todo update(@RequestBody Todo todo){
        if(todo.getId()!=null) {
            return service.save(todo);
        }
        throw new RuntimeException("No existe el id para actualizar");
    }
    @DeleteMapping("api/delete/{id}")
    public void delete(@RequestParam("id")Long id){
        service.delete(id);
    }
    @GetMapping(value = "api/{id}/get")
    public Todo get(@RequestParam("id") Long id) {
        return service.get(id);
    }

}
