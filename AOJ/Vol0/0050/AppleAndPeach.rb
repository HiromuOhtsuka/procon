str = STDIN.gets()
str.gsub!("apple", "deach")
str.gsub!("peach", "dpple")
str.gsub!("deach", "peach")
str.gsub!("dpple", "apple")
puts str
