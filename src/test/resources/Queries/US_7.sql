select * from books;
select full_name,b.name,bb.borrowed_date from users u
inner join book_borrow bb on u.id = bb.user_id
 inner join books b on bb.book_id = b.id
where full_name='Test Student 60'
order by 3 desc;


