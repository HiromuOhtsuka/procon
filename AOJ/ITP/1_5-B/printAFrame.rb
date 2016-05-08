while true
  args = STDIN.gets().chomp!.split(/\s/)
  h = args[0].to_i; w = args[1].to_i
  if w == 0 && h == 0
    exit
  end
  for i in 0...w
    print '#'
  end
  puts
  for i in 1...(h - 1)
    print '#'
    for j in 1...(w - 1)
      print '.'
    end
    puts '#'
  end
  for i in 0...w
    print '#'
  end
  puts
  puts
end
