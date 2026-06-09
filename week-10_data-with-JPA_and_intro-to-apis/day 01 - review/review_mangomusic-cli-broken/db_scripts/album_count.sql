SELECT ar.primary_genre AS genre
    , a.title AS album_title
    , ar.name AS artist
    , COUNT(ap.play_id) AS play_count
#     , (
#         SELECT count(*)
#         FROM album_plays as iap
#         INNER JOIN albums as ia on iap.album_id = ia.album_id
#         INNER JOIN artists as iar on ia.artist_id = iar.artist_id
#         WHERE iar.primary_genre = ar.primary_genre
#     ) AS genre_play_count
    , ROW_NUMBER() OVER (
        PARTITION BY primary_genre
        ORDER BY COUNT(ap.play_id) DESC
    ) as genre_rank
FROM album_plays AS ap
INNER JOIN albums AS a
    ON ap.album_id = a.album_id
INNER JOIN artists AS ar
    ON a.artist_id = ar.artist_id
WHERE completed = 1
GROUP BY genre
    , album_title
    , artist
ORDER BY genre
    , play_count DESC

;


