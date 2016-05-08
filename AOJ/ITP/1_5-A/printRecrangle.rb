while true
  args = STDIN.gets().chomp!.split(/\s/)
  h = args[0].to_i(); w = args[1].to_i()
  if h == 0 && w == 0
    exit
  end
  for i in 0...h
    for j in 0...w
      print '#'
    end
    puts
  end
  puts
end
