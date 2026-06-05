SELECT
        ar.primary_genre AS genre,
        al.title AS album_title,
        ar.name AS artist_name,
        COUNT(ap.play_id) AS play_count,
        (SELECT COUNT(*) + 1
            FROM (
				SELECT 
						ar2.primary_genre AS genre, 
						al2.album_id, 
						COUNT(ap2.play_id) as play_count
					FROM album_plays ap2
					JOIN albums al2
						ON ap2.album_id = al2.album_id
					JOIN artists ar2
						ON al2.artist_id = ar2.artist_id
					WHERE ar2.primary_genre = ar.primary_genre
					GROUP BY ar2.primary_genre, al2.album_id
				) other_albums
                WHERE other_albums.genre = ar.primary_genre AND other_albums.play_count > COUNT(ap.play_id)
            ) AS genre_rank
    FROM album_plays ap
    JOIN albums al
        ON ap.album_id = al.album_id
    JOIN artists ar
        ON al.artist_id = ar.artist_id
    GROUP BY ar.primary_genre, al.album_id, al.title, ar.name
    ORDER BY genre, genre_rank

