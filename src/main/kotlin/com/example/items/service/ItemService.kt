package com.example.items.service

import com.example.items.model.Item
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.concurrent.atomic.AtomicLong

@Service
class ItemService {

    private val items = ArrayList<Item>()
    private val idGenerator = AtomicLong(1)

    fun addItem(item: Item): Mono<Item> {
        val newItem = item.copy(id = idGenerator.getAndIncrement())
        items.add(newItem)
        return Mono.just(newItem)
    }

    fun getItemById(id: Long): Mono<Item> {
        val item = items.find { it.id == id }
        return if (item != null) Mono.just(item)
        else Mono.empty()
    }
}
