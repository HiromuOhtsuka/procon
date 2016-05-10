line = STDIN.gets()
words = line.split(/\s|,|\./)
  first = true
  words.each do |word|
  if word.length >= 3 && word.length <= 6
  if !first
  print " " + word
  else
  print word
  first = false
  end
  end
  end
  puts
