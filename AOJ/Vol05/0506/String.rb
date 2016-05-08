while (n = STDIN.gets().to_i()) != 0
  str = STDIN.gets().chomp!()
  for i in 0...n
    out = String.new()
    count = 0
    len = str.length
    for j in 1...len
      if str[j - 1] == str[j]
        count += 1
      else
        count += 1
        out << count.to_s()
        out << str[j - 1]
        count = 0
      end
    end
    count += 1
    out << count.to_s()
    out << str[len - 1]
    str = out.clone()
  end
  puts out
end
