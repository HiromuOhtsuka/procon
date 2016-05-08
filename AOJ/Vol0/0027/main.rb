require 'date'

while true do
  str = STDIN.gets()
  month = str.split(/\s/)[0].to_i()
  day = str.split(/\s/)[1].to_i()
  if month == 0 && day == 0 then
    break
  end
  date = Date.new(2004, month, day)
  case date.wday()
    when 0 then puts "Sunday"
    when 1 then puts "Monday"
    when 2 then puts "Tuesday"
    when 3 then puts "Wednesday"
    when 4 then puts "Thursday"
    when 5 then puts "Friday"
    when 6 then puts "Saturday"
  end
end

