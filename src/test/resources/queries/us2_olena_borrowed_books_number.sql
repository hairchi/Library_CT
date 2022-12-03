select *
from books;

select count(*)
from books;

select *
from users;

select count(*)
from book_borrow;

select count(*)
from book_borrow
where is_returned = 0;

select count(*) as borrowedBooks
from book_borrow
where is_returned = 0;



