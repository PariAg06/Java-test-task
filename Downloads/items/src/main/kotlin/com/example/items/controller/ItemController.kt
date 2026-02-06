package com.example.items.controller

import com.example.items.model.Item
import com.example.items.service.ItemService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/items")
class ItemController(private val itemService: ItemService) {

    @PostMapping
    fun addItem(@Valid @RequestBody item: Item): Mono<ResponseEntity<Item>> {
        return itemService.addItem(item)
            .map { ResponseEntity.ok(it) }
    }

    @GetMapping("/{id}")
    fun getItem(@PathVariable id: Long): Mono<ResponseEntity<Item>> {
        return itemService.getItemById(id)
            .map { ResponseEntity.ok(it) }
            .defaultIfEmpty(ResponseEntity.notFound().build())
    }
}
