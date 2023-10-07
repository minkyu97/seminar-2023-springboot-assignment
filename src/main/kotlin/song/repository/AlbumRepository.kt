package com.wafflestudio.seminar.spring2023.song.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface AlbumRepository : JpaRepository<AlbumEntity, Long> {
    @Query(
        """SELECT a FROM albums a 
            LEFT JOIN FETCH a.artist 
            WHERE a.title LIKE %:title% 
            ORDER BY LENGTH(a.title) ASC"""
    )
    fun findByTitleContainingOrderByTitleLengthAsc(title: String): List<AlbumEntity>
}
