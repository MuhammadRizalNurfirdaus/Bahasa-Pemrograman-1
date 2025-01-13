import pygame
import random

# Inisialisasi Pygame
pygame.init()

# Warna
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)

# Ukuran layar
screen_width = 800
screen_height = 600
screen = pygame.display.set_mode((screen_width, screen_height))

# Player
player_width = 50
player_height = 50
player_x = screen_width // 2
player_y = screen_height - player_height
player_speed = 5

# Bintang
star_width = 30
star_height = 30
star_x = random.randint(0, screen_width - star_width)
star_y = -star_height
star_speed = 3

# Skor
score = 0
font = pygame.font.SysFont(None, 36)

# Loop utama game
running = True
while running:
    # Event handling
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

    # Gerakan player
    keys = pygame.key.get_pressed()
    if keys[pygame.K_LEFT] and player_x > 0:
        player_x -= player_speed
    if keys[pygame.K_RIGHT] and player_x < screen_width - player_width:
        player_x += player_speed

    # Gerakan bintang
    star_y += star_speed
    if star_y > screen_height:
        star_x = random.randint(0, screen_width - star_width)
        star_y = -star_height

    # Deteksi penangkapan
    if player_x < star_x < player_x + player_width and player_y < star_y < player_y + player_height:
        score += 1
        star_x = random.randint(0, screen_width - star_width)
        star_y = -star_height

    # Tampilan
    screen.fill(WHITE)
    pygame.draw.rect(screen, BLACK, (player_x, player_y, player_width, player_height))
    pygame.draw.rect(screen, BLACK, (star_x, star_y, star_width, star_height))
    score_text = font.render(f"Score: {score}", True, BLACK)
    screen.blit(score_text, (10, 10))

    pygame.display.flip()
    pygame.time.delay(30)

pygame.quit()