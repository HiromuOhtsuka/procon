count = STDIN.gets().to_i
  count.times do
line = STDIN.gets()
  line.gsub!(/Hoshino/, "Hoshina")
  puts line
  end
