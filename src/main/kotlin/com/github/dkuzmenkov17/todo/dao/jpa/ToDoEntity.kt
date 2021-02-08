package com.github.dkuzmenkov17.todo.dao.jpa

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.PrePersist
import javax.persistence.PreUpdate
import javax.persistence.Table
import javax.persistence.Temporal
import javax.persistence.TemporalType

@Entity(name = "todo")
@Table(name = "todo")
class ToDoEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        @Column(name = "title")
        var title: String,
        @Column(name = "iscomplete")
        var isComplete: Boolean = false
) {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false, insertable = true)
    lateinit var createdAt: Calendar

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", insertable = true, updatable = true)
    lateinit var updatedAt: Calendar

    @PrePersist
    fun onCreate() {
        val utcTime = Calendar.getInstance()

        createdAt = utcTime
        updatedAt = utcTime.clone() as Calendar
    }

    @PreUpdate
    fun onUpdate() {
        updatedAt = Calendar.getInstance()
    }

    override fun equals(other: Any?): Boolean {
        other ?: return false
        if (this === other) return true
        other as ToDoEntity
        return this.id != null && this.id == other.id
    }

    override fun hashCode() = 25
}